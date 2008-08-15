package calc;

import java.io.IOException;
import java.rmi.RemoteException;


public interface Subtracter {
  public static class MyIOException extends IOException {
    public MyIOException(String str) {
      super(str);
    }
  }

  public static class MyRemoteException extends RemoteException {
    public MyRemoteException(String str) {
      super(str);
    }
  }
 
  public int subtract(int x, int y) throws MyRemoteException;

  public int subtract3(int x, int y, int z) throws MyIOException;
}