package com.simplicityitself.training

/**
 * Created by vergil01 on 21/09/2015.
 */
class CountFiles {
    Integer countFiles(String path, String suffix) {
        if (path == null) {
            //get path of where the script is called from
            path = System.getProperty("user.dir")
        }
        def files = []
        def directory = new File(path)
        if (directory.exists()) {
            directory.eachFile {
                if (suffix != null && !suffix.isEmpty() && it.name.endsWith(suffix)) {
                    files << it
                }
            }
        }
        return files.size()
    }
}
