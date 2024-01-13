package org.learning.constants;

import org.learning.util.ReadPropFile;

import java.io.FileNotFoundException;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final String REPORTPATH = System.getProperty("user.dir") + "/extent-test-output/";

    public static String getConfigfilepath() {
        return CONFIGFILEPATH;
    }

    public static String getReportpath() throws FileNotFoundException {
        return REPORTPATH + "index.html";

    }
}
