package com.microsoft.appcenter.assets.datacontracts;

import java.io.File;

/**
 * Class representing the downloaded update package.
 */
public class AssetsDownloadPackageResult {

    /**
     * The file containing the update.
     */
    private File downloadFile;

    /**
     * Whether the file is zipped.
     */
    private boolean isZip;

    /**
     * Creates an instance of the class.
     *
     * @param downloadFile the file containing the update.
     * @param isZip        whether the file is zipped.
     */
    public AssetsDownloadPackageResult(File downloadFile, boolean isZip) {
        this.downloadFile = downloadFile;
        this.isZip = isZip;
    }

    /**
     * Gets the download file and returns it.
     *
     * @return download file.
     */
    public File getDownloadFile() {
        return downloadFile;
    }

    /**
     * Gets whether the file is zipped.
     *
     * @return whether the file is zipped.
     */
    public boolean isZip() {
        return isZip;
    }
}
