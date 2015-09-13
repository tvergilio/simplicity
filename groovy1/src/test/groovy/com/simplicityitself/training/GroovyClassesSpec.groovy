package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

class GroovyClassesSpec extends Specification {
    def "Fetch all todo items"() {
        given: "A populated todo list"
        def todos = new TodoList()
        todos.addItem(new Item(summary: "test", dueDate: new Date() + 4))
        todos.addItem(new Item(summary: "Buy groceries", dueDate: new Date() + 1))

        when: "I retrieve all the items"
        def result = todos.allItems

        then: "I get the items I added"
        result.size() == 2
        result[0].summary == "test"
    }

    @Unroll
    def "Fetch items due before a given date"() {
        given: "A populated todo list"
        def todos = new TodoList()
        todos.addItem(new Item(summary: "test", dueDate: new Date() + 4))
        todos.addItem(new Item(summary: "Buy groceries", dueDate: new Date() + 1))

        when: "I retrieve items due by a given date"
        def result = todos.dueBefore(dueDate)

        then: "I get the items I added"
        result.size() == expectedCount
        if (result.size() == 1) result[0].summary == "Buy groceries"

        where:
        dueDate   | expectedCount
        new Date()| 0
        new Date() + 2 | 1
        new Date() + 10 | 2
    }

    def "Append items from just summaries"() {
        given: "A populated todo list"
        def todos = new TodoList()
        todos.addItem(new Item(summary: "test", dueDate: new Date() + 4))
        todos.addItem(new Item(summary: "Buy groceries", dueDate: new Date() + 1))

        when: "I add a summary using the left shift operator"
        todos << "Walk the dog"

        then: "The last item in the todo list is the one I added"
        todos.allItems.size() == 3
        todos.allItems[-1].summary == "Walk the dog"
        todos.allItems[-1].dateCreated <= new Date()
        todos.allItems[-1].dateCreated >= todos.allItems[0].dateCreated
    }

    def "Can't change dateCreated for an item"() {
        given: "A new item"
        def item = new Item(summary: "test", dueDate: new Date() + 4)

        when: "I try to change its creation date"
        item.dateCreated = new Date() + 1

        then: "A read-only exception is thrown"
        ReadOnlyPropertyException ex = thrown()
        ex.message.contains "Cannot set readonly property: dateCreated"
    }
}
