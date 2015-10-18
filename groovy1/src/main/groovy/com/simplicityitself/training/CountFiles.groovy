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
        def file = new File(path)
        if (file.exists()) {
            file.eachFile { subFile ->
                if (suffix && subFile.name.endsWith(suffix)) {
                    files << subFile
                }
            }
        }
        return files.size()
    }
}
