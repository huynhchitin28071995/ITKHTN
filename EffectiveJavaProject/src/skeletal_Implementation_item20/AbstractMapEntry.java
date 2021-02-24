package skeletal_Implementation_item20;

import java.util.Map;
import java.util.Objects;

//Skeletal implementation class
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
	// implements methods or make the class abstract

	// Entries in a modifiable map must override this method
	@Override
	public V setValue(V value) {
		throw new UnsupportedOperationException();
	}

	// Implements the general contract of Map.Entry.equals
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Map.Entry)) {
			return false;
		}
		Map.Entry<K, V> e = (Map.Entry<K, V>) obj;
		return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
	}

	// Implements the general contract of Map.Entry.hashCode
	@Override
	public int hashCode() {
		return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
	}

	@Override
	public String toString() {

		return getKey() + " = " + getValue();
	}
}
