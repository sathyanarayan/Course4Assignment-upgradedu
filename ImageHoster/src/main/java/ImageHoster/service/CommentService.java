package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	//This method calls the uploadcomments() method of CommentRepository and
	// provides the comment to be added to database as input param
	public void uploadComment(Comment comment){ commentRepository.uploadcomments(comment);}

	//This method call getCommentsofimage() method of CommentRepository to retrieve all the comments of the image.
	// It provides image as input param
	public List<Comment> getComments(Image image){return commentRepository.getCommentsofimage(image);}
}
