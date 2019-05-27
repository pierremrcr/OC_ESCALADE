package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Commentaire;
import org.projet6.model.bean.Spot;


public interface SpotManager {
	
	// Renvoie la liste des spots

	List<Spot> getListSpot();
	
	// Renvoie Renvoie le spot demandé en fonction de son ID
	
    Spot getSpot(int id);
    
    List<Spot> getSpotByRegion(String region);
    
    void ajoutSpot(Spot spot);
    
    void deleteSpot(int id);
    
    void updateSpot(Spot spot);
    
    //public List<Spot> rechercheMultiCriteres (int nombreDepoints, String typeCotation);
    
    public List<Spot> rechercheMultiCriteres(String region, int nombreDePoints, String typeCotation);

	void ajoutCommentaire(Commentaire commentaire, Integer id);
    
}