package com.simplicityitself.training

/**
 * <p>In this exercise, you need to implement your own classes. This will give
 * you practice with class definitions, properties, and operator overloading.
 * See the Groovy quick reference for details on defining methods, properties,
 * and so on in classes.</p>
 * <p>TODO #35: This class should contain a list of {@link Item} objects.
 * In addition, add the following:</p>
 * <ul>
 *   <li>An <tt>addItem(Item)</tt> method that adds a new <tt>Item</tt>
 *   instance to the internal list.</li>
 *   <li>A read-only <tt>allItems</tt> property that returns a copy of the
 *   list of items.</li>
 *   <li>A <tt>dueBefore(Date)</tt> method that returns a list of all items
 *   that have a due date before the given one.</li>
 *   <li>Support for the <tt>&lt;&lt;</tt> (left shift) operator, which
 *   creates a new <tt>Item</tt> using the given <em>string</em> as the
 *   item's summary. You don't need to initialise the item's due date in
 *   this method.</li>
 * </ul>
 * <p>If you're not sure about method signatures or other details, you might
 * be able to work them out from any error messages reported by the tests.
 * If you're still not sure what to do, ask.</p>
 */
class TodoList {
    List<Item> items
    final List<Item> allItems

    TodoList() {
        items = new ArrayList<>()
    }

    List<Item> addItem(Item item) {
        items.add(item)
        return items
    }

    List<Item> getAllItems() {
        return items
    }

    List<Item> dueBefore(Date date) {
        List<Item> results = new ArrayList<>()
        for (Item item in items) {
            if (item.dueDate < date) {
                results.add(item)
            }
        }
        return results
    }

    TodoList leftShift(String summary) {
        items.add(new Item([summary: summary]))
        return this
    }

}

/**
 * <p>TODO #35: This class represents a TODO item and needs populating with the
 * following properties:</p>
 * <ul>
 *   <li>A string <tt>summary</tt>.</li>
 *   <li>A <tt>dueDate</tt> (of type <tt>Date</tt>).</li>
 *   <li>A read-only <tt>dateCreated</tt> that is initialized with the current
 *   date and time when the object is created.</li>
 * </ul>
 */
class Item {
    String summary
    Date dueDate
    final Date dateCreated

    Item() {
        dateCreated = new Date(System.currentTimeMillis())
    }
}
