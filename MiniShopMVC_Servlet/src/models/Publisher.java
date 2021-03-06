package models;

public class Publisher {
	private final int publisherId;
	private final String publisherName;

	@Override
	public boolean equals(Object obj) {
		return this.publisherId == ((Publisher) obj).getPublisherId()
				&& this.publisherName == ((Publisher) obj).getPublisherName() && this == (Publisher) obj;
	}

	@Override
	public Publisher clone() throws CloneNotSupportedException {
		return this;
	}

	@Override
	public String toString() {
		return "Publisher id: " + this.publisherId + ", Publisher Name: " + this.publisherName;
	}

//	public static Publisher newInstance() {
//		return new Publisher();
//	}

	public int getPublisherId() {
		return publisherId;
	}

	// can not set field if declare final
//	public void setPublisherId(int publisherId) {
//		this.publisherId = publisherId;
//	}

	public String getPublisherName() {
		return publisherName;
	}

	// can not set field if declare final
//	public void setPublisherName(String publisherName) {
//		this.publisherName = publisherName;
//	}

	public static class Builder {
		private int publisherId; // Must initialize in constructor if declare final
		private String publisherName;

		public Builder() {
		}

		public Builder publisherId(int publisherId) {
			this.publisherId = publisherId;
			return this;
		}

		public Builder publisherName(String publisherName) {
			this.publisherName = publisherName;
			return this;
		}

		public Publisher build() {
			return new Publisher(this);
		}

	}

	public Publisher(Builder builder) {
		this.publisherId = builder.publisherId;
		this.publisherName = builder.publisherName;
	}

}
