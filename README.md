# KtDataTagLib

Little wrapper of the Minecraft's Tag API made to make my life easier. Maybe it will make yours too.

## Installing

build.gradle
```groovy
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
```
```groovy
    dependencies {
        modApi 'com.github.NathanPB:KtDataTagLib:VERSION'
        include 'com.github.NathanPB:KtDataTagLib:VERSION'
    }
```

See the versions [in the releases page](https://github.com/NathanPB/KtDataTagLib/releases)

## Example Usage

```kotlin
class DummyData(tag: CompoundTag) : MutableCompoundData(tag) {
    val counter by persistent(0, Serializers.INT)
    val idiotIds by persistent(emptyList(), Serializers.INT_LIST) // Works with IMMUTABLE lists too
    val idiotEnum by persistent(TestEnum.A, EnumSerializer(TestEnum::class.java)) // Enums require you to manually instantiate the serializer, not big deal
    val godsUUID by persistent(UUID.fromString("f8605001d8e14a379765ffc0675f3324"), Serializers.UUID) // UUIDs are valid too
    val compound by persistent(CompoundTag(), Serializers.COMPOUND_TAG) // And so compound tags are
    val id by persistent(Identifier("dml-refabricated", "deep_learner"), Serializers.IDENTIFIER) // And with identifiers too, how could I forget that?
}
```

It works with all the primitive data types and String too, just pick the right serializer

```kotlin
val tag: CompoundTag = stack.orCreateTag // A CompoundTag you got from somewhere, does not matter where it came from
val data = DummyData(tag)

data.counter += 10 // I'll increment this counter because I'm such a random person
println(data.counter) // > 10

// Oh god my counter really incremented how is that possible
```

For more examples check the [example mod](https://github.com/NathanPB/KtDataTagLib/tree/master/src/main/kotlin/dev/nathanpb/example), its really idiot but it helps

## License

Copyright 2020 Nathan P. Bombana

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
