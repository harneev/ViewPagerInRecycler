package view.pager.recycler.utils


object Check {

    fun isEmpty(string: String?): Boolean {
        try {

            if (string == null || string.trim { it <= ' ' }.isEmpty() || string.isEmpty() || string.isEmpty()
                    || string.equals("null", ignoreCase = true)) {
                return true
            }

        } catch (e: Exception) {
            return false
        }

        return false
    }

    fun isEmpty(value: Int?): Boolean {
        try {

            if (value == null || value == -1 || value == 0) {
                return true
            }

        } catch (e: Exception) {
            return false
        }

        return false
    }
}
