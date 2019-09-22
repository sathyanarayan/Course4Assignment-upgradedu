package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ImageService imageService;

	//This method is called when the user intend to post comment for an image.
	//Method has the reference parameters id of theimage, comment,model and the respective session
	//The logic of the method is that at first from the id it retrieves the image and input the comment along the mapped image and user id to comment table
	//Returns 'mages/image.html', displaying all the comments of that image
	@RequestMapping(value ="/image/{id}/{title}/comments")
	public String createComments (@PathVariable("id") int image_id, @RequestParam("comment") String comment_inp, Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggeduser");
		Image image1 = imageService.getImage(image_id);
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setImage(image1);
		comment.setText(comment_inp);
		comment.setCreatedDate(new Date());
		commentService.uploadComment(comment);
		//Get all the comments mapped of that image
		List<Comment> comments = commentService.getComments(image1);
		model.addAttribute("image", image1);
		model.addAttribute("tags", image1.getTags());
		model.addAttribute("comments", comments);
		return "images/image";
	}
}
