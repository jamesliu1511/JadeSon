package com.jade.path.processor;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JPathValue extends JsonElement {
	private final String name;
	private final JsonElement content;
	private JPathValue parent;

	public JPathValue(String name, JsonElement content) {
		this.name = name;
		this.content = content;
	}

	public JPathValue(String name, JsonElement content, JPathValue parent) {
		this.name = name;
		this.content = content;
		this.parent = parent;
	}

	public JPathValue(JsonElement content) {
		this.name = "*";
		this.content = content;
	}
	
	public JPathValue(JsonElement content, JPathValue parent) {
		this.name = "*";
		this.content = content;
		this.parent = parent;
	}

	public void setParent(JPathValue parent) {
		this.parent = parent;
	}

	public JPathValue getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}

	public JsonElement getContent() {
		return content;
	}

	public JPathValue getChild(String name) {
		if (this.content.isJsonArray()) {
			JsonArray array = this.content.getAsJsonArray();
			JsonArray chArray = new JsonArray();
			for (JsonElement el : array) {
				if (el.isJsonObject()) {
					JsonObject ch = el.getAsJsonObject();
					chArray.add(ch.get(name));
				}
			}
			return new JPathValue(name, chArray, this);
		} else if (this.content.isJsonObject()) {
			return new JPathValue(name, this.content.getAsJsonObject().get(name), this);
		}

		return null;
	}

	@Override
	public String toString() {
		return "JPathValue [name=" + name + ", content=" + content + "]";
	}

	@Override
	public JsonElement deepCopy() {
		JPathValue copy = new JPathValue(this.content.deepCopy());

		if (this.parent != null) {
			copy.parent = new JPathValue(this.parent.deepCopy());
		}

		return copy;
	}

	@Override
	public boolean isJsonArray() {
		return this.content.isJsonArray();
	}

	@Override
	public boolean isJsonObject() {
		return this.content.isJsonObject();
	}

	@Override
	public boolean isJsonPrimitive() {
		return this.content.isJsonPrimitive();
	}

	@Override
	public boolean isJsonNull() {
		return this.content.isJsonNull();
	}

	@Override
	public JsonObject getAsJsonObject() {
		return this.content.getAsJsonObject();
	}

	@Override
	public JsonNull getAsJsonNull() {
		return this.content.getAsJsonNull();
	}

	@Override
	public boolean getAsBoolean() {
		return this.content.getAsBoolean();
	}

	@Override
	public Number getAsNumber() {
		return this.content.getAsNumber();
	}

	@Override
	public String getAsString() {
		return this.content.getAsString();
	}

	@Override
	public double getAsDouble() {
		return this.content.getAsDouble();
	}

	@Override
	public float getAsFloat() {
		return this.content.getAsFloat();
	}

	@Override
	public long getAsLong() {
		return this.content.getAsLong();
	}

	@Override
	public int getAsInt() {
		return this.content.getAsInt();
	}

	@Override
	public byte getAsByte() {
		return this.content.getAsByte();
	}

	@Override
	public char getAsCharacter() {
		return this.content.getAsCharacter();
	}

	@Override
	public BigDecimal getAsBigDecimal() {
		return this.content.getAsBigDecimal();
	}

	@Override
	public BigInteger getAsBigInteger() {
		return this.content.getAsBigInteger();
	}

	@Override
	public short getAsShort() {
		return this.content.getAsShort();
	}

	@Override
	public JsonPrimitive getAsJsonPrimitive() {
		return this.content.getAsJsonPrimitive();
	}

	@Override
	public JsonArray getAsJsonArray() {
		return this.content.getAsJsonArray();
	}
}
