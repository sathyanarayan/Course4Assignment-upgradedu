package ImageHoster.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//This class is a JPA entity
@Entity
//Table mapping
@Table(name = "comment")
public class Comment {

	// This attribute is a primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private Integer id;

	//Comment given user for the image
	@Column(name = "comment")
	private String text;

	//Date at which comment was posted
	@Column(name = "Create_date")
	private Date createdDate;

	//User details , of the one who posted the comment
	@ManyToOne(fetch = FetchType.EAGER)
	//Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
	@JoinColumn(name = "user_id")
	private User user;

	//Image to which comment is to be mapped
	@ManyToOne(fetch = FetchType.EAGER)
	//Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
	@JoinColumn(name = "image_id")
	private Image image;

	public Comment ()
	{}
	public Comment (int id,String text,Date createdDate)
	{this.id = id;
	this.text = text;
	this.createdDate = createdDate;
	}

	public Comment (int id,String text)
	{this.id = id;
	 this.text = text;
	}
    //Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
