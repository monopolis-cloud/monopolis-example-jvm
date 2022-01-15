package verysecuresystems

val Array<String>.port: Int get() = firstOrNull()?.toInt() ?: 9000
