/*
 * Copyright 2020 Nathan P. Bombana
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package dev.nathanpb.ktdatatag.serializer

import net.minecraft.nbt.CompoundTag

interface DataSerializer<T> {
    fun has(tag: CompoundTag, key: String) = tag.contains(key)
    fun write(tag: CompoundTag, key: String, data: T)
    fun read(tag: CompoundTag, key: String): T

    fun nullable() = Nullable(this)
    fun isNullable() = false

    class Nullable<T> internal constructor(private val wrapped: DataSerializer<T>) : DataSerializer<T?> {

        override fun isNullable() = true

        override fun write(tag: CompoundTag, key: String, data: T?) {
            if (data == null) {
                tag.remove(key)
            } else wrapped.write(tag, key, data)
        }

        override fun read(tag: CompoundTag, key: String): T? {
            return if (has(tag, key)) {
                wrapped.read(tag, key)
            } else null
        }

    }
}
