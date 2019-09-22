package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

	@PersistenceUnit(unitName = "imageHoster")
	private EntityManagerFactory emf;

	//The method receives the Comment object to be persisted in the database
	//Creates an instance of EntityManager
	//Starts a transaction
	//The transaction is committed if it is successful
	//The transaction is rolled back in case of unsuccessful transaction
	public Comment uploadcomments (Comment newcomment) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try{
			transaction.begin();
			em.persist(newcomment);
			transaction.commit();
		}
	catch (Exception e) {
		transaction.rollback();
	}
        return newcomment;
	}

	//The method creates an instance of EntityManager
	//Executes JPQL query to fetch all the comments of given image from the database
	//Returns the list of all the comments of the image  fetched from the database
	public List<Comment> getCommentsofimage(Image image) {
		EntityManager em = emf.createEntityManager();
		List<Comment> resultList = null;
		try{TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i where i.image =:image_id ", Comment.class).setParameter("image_id",image);
			resultList = query.getResultList();}
        catch (Exception e)
		{e.printStackTrace();}
		return resultList;
	}
}
