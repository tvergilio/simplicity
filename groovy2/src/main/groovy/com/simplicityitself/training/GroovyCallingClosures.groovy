package com.simplicityitself.training

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam

/**
 * Created by Thalita on 06/10/2015.
 */
class GroovyCallingClosures {
    public <S, T> List<T> manualCollect(Collection<S> self,
                                        @ClosureParams(FirstParam.FirstGenericType.class) Closure<T> transform) {
        List<T> results = []
        self.each {
            results.add(transform.call(it))
        }
        return results
    }

    public <T> Boolean ifAllSatisfy(Collection<String> self,
                                    @ClosureParams(FirstParam.FirstGenericType.class) Closure<T> transform) {
        if (!transform) {
            return Boolean.FALSE
        }
        return self?.count(transform) == self?.size()
    }
}
