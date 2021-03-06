package com.microsoft.appcenter.assets.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Indicates when you would like to check for (and install) updates from the Assets server.
 */
public enum AssetsCheckFrequency {

    /**
     * When the app is fully initialized (or more specifically, when the root component is mounted).
     */
    @SerializedName("0")
    ON_APP_START(0),

    /**
     * When the app re-enters the foreground.
     */
    @SerializedName("1")
    ON_APP_RESUME(1),

    /**
     * Don't automatically check for updates, but only do it when <code>Assets.sync()</code> is manually called inside app code.
     */
    @SerializedName("2")
    MANUAL(2);

    private final int value;

    AssetsCheckFrequency(int value) {
        this.value = value;
    }

    /**
     * Gets the assigned enum value.
     *
     * @return integer assigned to enum item.
     */
    public int getValue() {
        return this.value;
    }
}
