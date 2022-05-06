package assignments;

import java.util.Collections;
import java.util.List;

/**
 * Strategy class which implements the scheduling which depends on: Order
 * assignment were created and added to the task list.
 */

public class AssignedSchedulingStrategy extends ValidateParameters implements SchedulingStrategy {

  private static final String STRATEGY_NAME = "assigned";

  @Override
  public String schedule(List<Assignment> assignmentList) {
    validateList(assignmentList);
    validateListContent(assignmentList);

    Collections.sort(assignmentList, (p1, p2) -> p1.getNumber() - p2.getNumber());
    return STRATEGY_NAME;
  }

}
