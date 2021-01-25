/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import java.util.function.Function;

@FunctionalInterface
public interface DataProcessor<T, R> {

    void init();

    default R process(T data, Function<T, R> algorithm) {
        return algorithm.apply(data);
    }
}
