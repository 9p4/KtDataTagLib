
import net.ersei.ktdatatag.data.MutableCompoundData
import net.ersei.ktdatatag.serializer.Serializers
import net.minecraft.nbt.NbtCompound
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MutableCompoundDataTest {

    @Test
    fun testSimple() {
        val data = object: MutableCompoundData(NbtCompound()) {
            var field by persistent(Serializers.STRING)
        }

        assertEquals("", data.field)

        data.field = "foobar"
        assertEquals("foobar", data.field)
    }

    @Test
    fun testSimpleNullable() {
        val data = object: MutableCompoundData(NbtCompound()) {
            var field by persistent(Serializers.STRING.nullable())
        }

        assertNull(data.field)

        data.field = "foobar"
        assertEquals("foobar", data.field)

        data.field = null
        assertNull(data.field)
    }

    @Test
    fun testDefaulted() {
        val data = object: MutableCompoundData(NbtCompound()) {
            var field by persistentDefaulted("foobar", Serializers.STRING)
        }

        assertEquals("foobar", data.field)

        data.field = "notfoobar"
        assertEquals("notfoobar", data.field)
    }

    @Test
    fun testDefaultedNullable() {
        val data = object: MutableCompoundData(NbtCompound()) {
            var field by persistentDefaulted("foobar", Serializers.STRING.nullable())
        }

        assertEquals("foobar", data.field)

        data.field = null
        assertEquals("foobar", data.field)

        data.field = "notfoobar"
        assertEquals("notfoobar", data.field)
    }
}
