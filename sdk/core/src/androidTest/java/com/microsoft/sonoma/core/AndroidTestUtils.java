package com.microsoft.sonoma.core;

import android.support.annotation.NonNull;

import com.microsoft.sonoma.core.ingestion.models.Device;
import com.microsoft.sonoma.core.ingestion.models.Log;
import com.microsoft.sonoma.core.ingestion.models.LogContainer;
import com.microsoft.sonoma.core.ingestion.models.json.MockLog;
import com.microsoft.sonoma.core.utils.UUIDUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public final class AndroidTestUtils {

    private static final Random RANDOM = new Random();

    private AndroidTestUtils() {
    }

    @NonNull
    public static LogContainer generateMockLogContainer() {
        LogContainer container = new LogContainer();
        List<Log> logs = new ArrayList<>();
        logs.add(generateMockLog());
        container.setLogs(logs);
        return container;
    }

    @NonNull
    public static MockLog generateMockLog() {
        MockLog log = new MockLog();
        log.setDevice(generateMockDevice());
        log.setSid(UUIDUtils.randomUUID());
        return log;
    }

    @NonNull
    private static Device generateMockDevice() {
        Device device = new Device();
        device.setSdkName("sonoma.android");
        device.setSdkVersion(String.format(Locale.ENGLISH, "%d.%d.%d", (RANDOM.nextInt(5) + 1), RANDOM.nextInt(10), RANDOM.nextInt(100)));
        device.setModel("S5");
        device.setOemName("HTC");
        device.setOsName("Android");
        device.setOsVersion(String.format(Locale.ENGLISH, "%d.%d.%d", (RANDOM.nextInt(5) + 1), RANDOM.nextInt(10), RANDOM.nextInt(100)));
        device.setOsBuild("LMY47X");
        device.setOsApiLevel(RANDOM.nextInt(9) + 15);
        device.setLocale("en_US");
        device.setTimeZoneOffset(RANDOM.nextInt(52) * 30 - 720);
        device.setScreenSize(String.format(Locale.ENGLISH, "%dx%d", (RANDOM.nextInt(4) + 1) * 1000, (RANDOM.nextInt(10) + 1) * 100));
        device.setAppVersion(String.format(Locale.ENGLISH, "%d.%d.%d", (RANDOM.nextInt(5) + 1), RANDOM.nextInt(10), RANDOM.nextInt(100)));
        device.setAppBuild(Integer.toString(RANDOM.nextInt(1000) + 1));
        device.setAppNamespace("com.microsoft.unittest");
        return device;
    }
}
