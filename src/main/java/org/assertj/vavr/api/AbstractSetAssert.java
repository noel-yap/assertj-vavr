package org.assertj.vavr.api;

import io.vavr.collection.Set;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.EnumerableAssert;

import java.util.Comparator;

abstract class AbstractSetAssert<SELF extends AbstractSetAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>,
        ACTUAL extends Set<? extends ELEMENT>,
        ELEMENT,
        ELEMENT_ASSERT extends AbstractAssert<ELEMENT_ASSERT, ELEMENT>>
        extends AbstractTraversableAssert<SELF, ACTUAL, ELEMENT, ELEMENT_ASSERT>
        implements EnumerableAssert<SELF, ELEMENT> {

    AbstractSetAssert(ACTUAL actual, Class<?> selfType) {
        super(actual, selfType);
    }
}
