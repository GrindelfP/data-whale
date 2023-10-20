package to.grindelf.datawhale.filemanager

import java.io.File

object FileProcessor {

    /**
     * Merges the given files into one file.
     */
    fun mergeFiles(filePaths: List<String>) {
        // 0. Form a list of files from the given paths and check their existence
        val files = filePaths.map { File(it) }
        files.forEach { file ->
            require(file.exists()) { "File ${file.absolutePath} does not exist." }
        }

        // 1. Read all files into strings
        val filesAsStrings = files.map { it.readText() }

        // 2. Check if all files' entries has an identifier 'num\n' at the first position
        // of each entry (except for headers)
        val stringsWithIds = provideEntriesIdentifiers(filesAsStrings)

        // 3. Analyze the string headers and create a complete header list
        val headers = stringsWithIds.map { it.substringBefore("\n").split(',') }.flatten().distinct()

        // 4. Merge all strings into one string
        val mergedData = merge(stringsWithIds, headers)

        // 5. Write the merged string to a file
        writeToFile(mergedData, files.first().parent)
    }

    /**
     * Writes the merged data to a file text file stored in the same
     * directory as the initial files and named 'merged-currentTimestamp.txt'.
     * @param mergedData The merged data to be written to a file.
     * @param pathPrefix The path to the directory, where the file should be stored.
     */
    private fun writeToFile(mergedData: String, pathPrefix: String) {
        val file = File("$pathPrefix/merged-${System.currentTimeMillis()}.txt")
        file.writeText(mergedData)
    }

    private fun merge(string: List<String>, headers: List<String>): String {
        TODO("Not yet implemented")
    }

    private fun provideEntriesIdentifiers(filesAsStrings: List<String>): List<String> {
        TODO("Not yet implemented")
    }
}