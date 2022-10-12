/*
 * Copyright 2020 Nathan P. Bombana
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.ersei.ktdatatag.serializer

@Suppress("private", "unused")
class Serializers {
    companion object {
        val INT = IntSerializer()
        val FLOAT = FloatSerializer()
        val DOUBLE = DoubleSerializer()
        val STRING = StringSerializer()
        val BYTE = ByteSerializer()
        val BOOLEAN = BooleanSerializer()
        val SHORT = ShortSerializer()
        val LONG = LongSerializer()
        val CHAR = CharSerializer()
        val COMPOUND_TAG = NbtCompoundSerializer()
        val UUID = UUIDSerializer()
        val IDENTIFIER = IdentifierSerializer()
        val ITEM_STACK = ItemStackSerializer()
        val BLOCKPOS = BlockPosSerializer()
        val VEC3D = Vec3dSerializer()
        val VEC3I = Vec3iSerializer()

        val INT_LIST = IntListSerializer()
        val FLOAT_LIST = FloatListSerializer()
        val DOUBLE_LIST = DoubleListSerializer()
        val STRING_LIST = StringListSerializer()
        val BYTE_LIST = ByteListSerializer()
        val BOOLEAN_LIST = BooleanListSerializer()
        val SHORT_LIST = ShortListSerializer()
        val LONG_LIST = LongListSerializer()
        val CHAR_LIST = CharListSerializer()
        val COMPOUND_TAG_LIST = NbtCompoundListSerializer()
        val UUID_LIST = UUIDListSerializer()
        val IDENTIFIER_LIST = IdentifierListSerializer()
        val ITEM_STACK_LIST = ItemStackListSerializer()
        val BLOCKPOS_LIST = BlockPosListSerializer()
        val VEC3D_LIST = Vec3dListSerializer()
        val VEC3I_LIST = Vec3iSerializer()
    }
}
