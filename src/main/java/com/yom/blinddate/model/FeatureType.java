package com.yom.blinddate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum FeatureType {
    NODE(true),
    LINK(true),
    ANDO_MPT(true),
    ANDO_SPT(true),
    COMPLEX_INTERSECTION(true),
    CONDITIONAL_PASS(true),
    CONDITIONAL_TURN_LEFT(true),
    CONDITIONAL_TOLL(true),
    HIPASS(true),
    TOLL_LANE(false);

    private boolean visible;

    public static final FeatureType featureTypes[];

    static {
        featureTypes = asArray(true);
    }

    public static FeatureType[] asArray() {
        return asArray(true);
    }

    public static FeatureType[] asArray(boolean visibleOnly) {
        return Arrays.stream(values())
                .filter(featureType -> !visibleOnly || featureType.visible)
                .toArray(FeatureType[]::new);
    }
}
