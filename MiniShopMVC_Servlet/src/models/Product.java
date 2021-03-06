package models;

public class Product {
	private int productId;
	private int categoryId;
	private int publisherId;
	private int authorId;
	private String isbn;
	private String title;
	private int pages;
	private int year;
	private String weight, size, description, content, imageURL;
	private int price;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int page) {
		this.pages = page;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", publisherId=" + publisherId
				+ ", authorId=" + authorId + ", isbn=" + isbn + ", title=" + title + ", page=" + pages + ", year=" + year
				+ ", weight=" + weight + ", size=" + size + ", description=" + description + ", content=" + content
				+ ", imageURL=" + imageURL + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + categoryId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + pages;
		result = prime * result + price;
		result = prime * result + productId;
		result = prime * result + publisherId;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (authorId != other.authorId)
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (pages != other.pages)
			return false;
		if (price != other.price)
			return false;
		if (productId != other.productId)
			return false;
		if (publisherId != other.publisherId)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	public static class Builder {
		private int productId;
		private int categoryId;
		private int publisherId;
		private int authorId;
		private String isbn;
		private String title;
		private int page;
		private int year;
		private String weight, size, description, content, imageURL;
		private int price;
		
		public Builder productId(int val) {
			this.productId = val;
			return this;
		}
		
		public Builder categoryId(int val) {
			this.categoryId = val;
			return this;
		}
		
		public Builder publisherId(int val) {
			this.publisherId = val;
			return this;
		}
		
		public Builder authorId(int val) {
			this.authorId = val;
			return this;
		}
		
		public Builder isbn(String val) {
			this.isbn = val;
			return this;
		}
		
		public Builder title(String val) {
			this.title = val;
			return this;
		}
		
		public Builder page(int page) {
			this.page = page;
			return this;
		}
		
		public Builder year(int year) {
			this.year = year;
			return this;
		}
		
		public Builder weight(String weight) {
			this.weight = weight;
			return this;
		}
		
		public Builder size(String size) {
			this.size = size;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder content(String content) {
			this.content = content;
			return this;
		}
		
		public Builder imageURL(String imageURL) {
			this.imageURL = imageURL;
			return this;
		}
		
		public Builder price(int price) {
			this.price = price;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}
	
	private Product(Builder b) {
		this.authorId = b.authorId;
		this.categoryId = b.categoryId;
		this.content = b.content;
		this.description = b.description;
		this.imageURL = b.imageURL;
		this.isbn = b.isbn;
		this.pages = b.page;
		this.price = b.price;
		this.productId = b.productId;
		this.publisherId = b.publisherId;
		this.size = b.size;
		this.title = b.title;
		this.weight = b.weight;
		this.year = b.year;
	}
}
