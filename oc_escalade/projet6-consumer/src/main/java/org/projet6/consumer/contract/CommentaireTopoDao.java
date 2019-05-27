package org.projet6.consumer.contract;

import java.util.List;


import org.projet6.model.bean.Commentaire;

public interface CommentaireTopoDao {
	
public Commentaire getCommentaireTopoByID(int id);

public List<Commentaire> getCommentaireTopoByTopoID(int id);
	
public Commentaire ajoutCommentaireTopo(Commentaire commentaireTopo, int topoId);

public List<Commentaire> listeCommentaireTopo();

public List<Commentaire> listeCommentaireTopoByTopoId(int topoId);

public void supprimeCommentaireTopo(int id);

public void deleteCommentaireTopoByUser(int id);

public void updateCommentaireTopo(Commentaire commentaireTopo);


}
