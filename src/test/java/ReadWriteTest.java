import com.evilco.mc.nbt.stream.NbtInputStream;
import com.evilco.mc.nbt.stream.NbtOutputStream;
import com.evilco.mc.nbt.tag.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
@RunWith (MockitoJUnitRunner.class)
public class ReadWriteTest {

	/**
	 * Tests read and write.
	 * @throws IOException
	 */
	@Test
	public void test () throws IOException {
		// create a hello world tag structure
		TagCompound compound = new TagCompound ("hello world");

		// add primitives
		compound.setTag (new TagByte ("byteTag", ((byte) 20)));
		compound.setTag (new TagByteArray ("byteArrayTag", new byte[] { 0, 1, 2, 3 }));
		compound.setTag (new TagDouble ("doubleTag", 4.2d));
		compound.setTag (new TagFloat ("floatTag", 4.2f));
		compound.setTag (new TagInteger ("integerTag", 42));
		compound.setTag (new TagIntegerArray ("integerArrayTag", new int[] { 21, 42, 84 }));
		compound.setTag (new TagLong ("longTag", 42l));
		compound.setTag (new TagShort ("shortTag", ((short) 42)));
		compound.setTag (new TagString ("stringTag", "Bananrama"));

		// add complex types
		TagList list = new TagList ("listTag");
		list.addTag (new TagString ("", "Hello"));
		list.addTag (new TagString ("", "World!"));
		compound.setTag (list);

		TagCompound compound1 = new TagCompound ("compoundTag");
		compound1.setTag (new TagString ("name", "Bananrama"));
		compound.setTag (compound1);

		// create output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();
		NbtOutputStream nbtOutputStream = new NbtOutputStream (outputStream);

		// write data
		nbtOutputStream.write (compound);

		// create input stream
		ByteArrayInputStream inputStream = new ByteArrayInputStream (outputStream.toByteArray ());
		NbtInputStream nbtInputStream = new NbtInputStream (inputStream);

		// read data
		ITag tag = nbtInputStream.readTag ();

		// verify output
		Assert.assertNotNull (tag);
	}
}