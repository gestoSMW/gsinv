/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Sortie;
import bean.SortieItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author the joker
 */
@Stateless
public class SortieItemFacade extends AbstractFacade<SortieItem> {

    @PersistenceContext(unitName = "gestionStockInventairePU")
    private EntityManager em;
    
    private List<SortieItem>sortieItems;
    private Sortie sortie;
    private SortieItem sortieItem;
    
    
    public void clone(SortieItem sortieItemSource,SortieItem sortieItemDestination){
        System.out.println("ha sortieItemSource ==> "+sortieItemSource);
        sortieItemDestination.setId(sortieItemSource.getId());
        sortieItemDestination.setQuantite(sortieItemSource.getQuantite());
        sortieItemDestination.setProduit(sortieItemSource.getProduit());
        
    }
   
    public SortieItem clone(SortieItem sortieItem){
        SortieItem cloned=new SortieItem();
        clone(sortieItem, cloned);
        return cloned;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SortieItemFacade() {
        super(SortieItem.class);
    }

    public List<SortieItem> getSortieItems() {
        return sortieItems;
    }

    public void setSortieItems(List<SortieItem> sortieItems) {
        this.sortieItems = sortieItems;
    }

    public Sortie getSortie() {
        return sortie;
    }

    public void setSortie(Sortie sortie) {
        this.sortie = sortie;
    }

    public SortieItem getSortieItem() {
        return sortieItem;
    }

    public void setSortieItem(SortieItem sortieItem) {
        this.sortieItem = sortieItem;
    }
    
}
