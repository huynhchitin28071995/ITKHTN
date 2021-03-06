package restControllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import businessLogics.AuthorBL;
import javaBeans.Author;

@RestController
public class RestAuthorController {
	@GetMapping("/rest-author")
	public List<Author> dsAuthor() {
		return AuthorBL.docTatCa();
	}
	
	@GetMapping("/rest-author/{id}")
	public Author docAuthor(@PathVariable(name="id")int id) {
		return AuthorBL.docTheoId(id);
	}
	
	@PostMapping("/them-author")
	public int themAuthor(@RequestBody Author author) {
		return AuthorBL.them(author);
	}
	
	@PutMapping("/sua-author")
	public void suaAuthor(@RequestBody Author author) {
		AuthorBL.sua(author.getAuthorId(), author.getAuthorName());
	}
	
	@DeleteMapping("/xoa-author/{id}")
	public void xoaAuthor(@PathVariable(name="id")int id) {
		AuthorBL.xoa(id);
	}
	@DeleteMapping("/xoa-author")
	public void xoaAuthor2(@RequestBody int id) {
		AuthorBL.xoa(id);
	}
}
