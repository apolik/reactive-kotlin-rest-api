package org.polik.reactivekotlinrestapi.exception

class NotFoundException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
}