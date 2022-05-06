package assignments;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Strategy class which implements the assignment scheduling which depends on:
 * Order that assignments are due (by their deadline).
 *
 * Assignment Property used for scheduling: getEndDate. If endDate matches then
 * sort by description.
 *
 */

public class DeadlineSchedulingStrategy extends ValidateParameters implements SchedulingStrategy {

  private static final String STRATEGY_NAME = "deadline";

  @Override
  public String schedule(List<Assignment> assignmentList) {
    validateList(assignmentList);
    validateListContent(assignmentList);

    Collections.sort(assignmentList,
        Comparator.comparing(Assignment::getEndDate).thenComparing(Assignment::compareTo));
    return STRATEGY_NAME;
  }

}
