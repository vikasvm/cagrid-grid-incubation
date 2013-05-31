/**
*============================================================================
*  The Ohio State University Research Foundation, Emory University,
*  the University of Minnesota Supercomputing Institute
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-grid-incubation/LICENSE.txt for details.
*============================================================================
**/
/**
*============================================================================
*============================================================================
**/
package calc;

public class Calculator implements Adder, Subtracter {
  public int add(int x, int y) {
    return x + y;
  }

  public int add(int x, int y, int z) {
    return x + y + z;
  }
  
  public int add(int xs[]) {
    int sum = 0;
    for(int x : xs) sum += x;
    return sum;
  }

  public int subtract(int x, int y) {
    return x - y;
  }
 
}

