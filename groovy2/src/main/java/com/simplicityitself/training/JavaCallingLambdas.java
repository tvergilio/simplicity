package com.simplicityitself.training;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Thalita on 06/10/2015.
 */
class JavaCallingLambdas {
    public <S, T> List<T> manualCollect(Collection<S> self,
                                        Function<S, T> function) {
        List<T> results = new ArrayList<>();
        if (function != null) {
            results = self.stream().map(function).collect(Collectors.toList());
        }
        return results;
    }

    public <T> Boolean ifAllSatisfy(Collection<T> self,
                                    Predicate<T> transform) {
        if (transform == null) {
            return Boolean.FALSE;
        }
        return self.stream().allMatch(transform);
    }
}
