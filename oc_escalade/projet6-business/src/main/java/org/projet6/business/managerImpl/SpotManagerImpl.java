package org.projet6.business.managerImpl;



import java.util.List;


import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.SpotManager;
import org.projet6.model.bean.Adresse;
import org.projet6.model.bean.Commentaire;
import org.projet6.model.bean.Longueur;
import org.projet6.model.bean.Secteur;
import org.projet6.model.bean.Spot;
import org.projet6.model.bean.Voie;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class SpotManagerImpl extends AbstractManager implements SpotManager {

	public List<Spot> getListSpot() {

		List<Spot> listeSpot = getDaoFactory().getSpotDao().listspot();
		
		for (Spot spot : listeSpot) {
			
			//Pour chaque spot de la liste, on récupère les secteurs voies et liées correspondant à ce spot grâce à la méthode fillSpot()
			fillSpot(spot);
		}
		
		return listeSpot;

	}

	public Spot getSpot(int id) {
		
		Spot spot = getDaoFactory().getSpotDao().getbyID(id);
		
		//on récupère les secteurs voies et liées correspondant à ce spot grâce à la méthode fillSpot()
		fillSpot(spot);
		
		return spot;
	}
	
    //Méthode pour afficher secteurs, voies et longueurs liés à un spot
	private void fillSpot(Spot spot) {

		//On récupère une liste de secteurs liées à l'ID du spot 
		List<Secteur> listeSecteurs = getDaoFactory().getSecteurDao().listSecteurBySpotID(spot.getId());

		for (Secteur secteur : listeSecteurs) {
			//On récupère une liste de voies liées à l'ID de chaque secteur
			List<Voie> listeVoies = getDaoFactory().getVoieDao().listeVoiesBySecteurID(secteur.getId());
			for (Voie voie : listeVoies) {
				//On récupère une liste de longueurs liées à l'ID de chaque voie
				List<Longueur> listeLongueurs = getDaoFactory().getLongueurDao().listeLongueursByVoieID(voie.getId());
			
			//On affecte la liste de longueurs récupérées à la voie
			voie.setListeLongueurs(listeLongueurs);
			}
			//On affecte la liste de voies récupérées au secteur
			secteur.setListeVoies(listeVoies);
		}
		//On affecte la liste de secteurs au spot
		spot.setListeSecteurs(listeSecteurs);
		
        List<Commentaire> listeCommentaires = getDaoFactory().getCommentaireDao().getCommentaireBySpot(spot.getId());
		
		spot.setListeCommentaires(listeCommentaires);
		
		//==> On a ainsi un spot avec les secteurs, voies et longueurs correspondant à ce spot

	}

	@Transactional(value = "txManager")
	public void ajoutSpot(final Spot spot) {
		
		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
			
				Adresse adresse = getDaoFactory().getAdresseDao().create(spot.getAdresse());
				
				spot.setAdresse(adresse);
	
				getDaoFactory().getSpotDao().create(spot);
				
				

			}
		});

	}
	
	

	public void deleteSpot(int id) {
	
		getDaoFactory().getSpotDao().supprimeSpot(id);
		
	}
	
	
  @Transactional(value = "txManager")
	public void updateSpot(final Spot spot) {
    
    TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

    vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
      
      @Override
      protected void doInTransactionWithoutResult(TransactionStatus status) {
    	
		  getDaoFactory().getSpotDao().updateSpot(spot);
		
		
      }
    });

  }

//	public List<Spot> rechercheMultiCriteres(int nombreDePoints, String typeCotation) {
//		
//		List<Spot> listeSpot = getDaoFactory().getSpotDao().rechercheMultiCriteres(nombreDePoints, typeCotation);
//		
//		return listeSpot;
//	}

	public List<Spot> rechercheMultiCriteres(String region,int nombreDePoints, String typeCotation) {
		
        List<Spot> listeSpot = getDaoFactory().getSpotDao().rechercheMultiCriteres(region,nombreDePoints, typeCotation);
		
		return listeSpot;
	}
	

	public List<Spot> getSpotByRegion(String region) {
		
		List<Spot> listeSpot = getDaoFactory().getSpotDao().getSpotByRegion(region);
		
		return listeSpot;
	}

	public void ajoutCommentaire(Commentaire commentaire, Integer spotId) {
		
		getDaoFactory().getCommentaireDao().ajoutCommentaireBySpotId(commentaire, spotId);
		
			
		
	}



}
