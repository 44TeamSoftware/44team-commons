package com.ffteam.commons.functions;

@FunctionalInterface
public interface ShortToByteFunction {
	byte applyAsByte(short s);
}

class TestShortToByteFunction {
	public byte[] transformArray(short[] array, ShortToByteFunction function) {
		byte[] transformedArray = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			transformedArray[i] = function.applyAsByte(array[i]);
		}
		return transformedArray;
	}
}