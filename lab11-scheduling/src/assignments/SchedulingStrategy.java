package assignments;

import java.util.List;

/**
 * Interface for scheduling strategy.
 */

public interface SchedulingStrategy {

  /**
   * Method that called for schedule.
   * 
   * @param assignmentList list of assignments that are scheduled
   * @return Strategy name is returned
   */
  String schedule(List<Assignment> assignmentList);

}
