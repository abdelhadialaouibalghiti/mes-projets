package modele.proprio;

import modele.proprio.Proprio;

public interface ProprioDao {
    public boolean addPropio(Proprio proprio) throws ClassNotFoundException;
    public boolean searchPropio(Proprio proprio) throws ClassNotFoundException;
}
