package assignments;

import java.util.Collections;
import java.util.List;

/**
 * Strategy class which implements the assignment scheduling which depends on:
 * Alphabetical (lexicographical) order of their descriptions.
 *
 * Assignment Property used for scheduling: description.
 *
 */

public class AlphabeticalSchedulingStrategy extends ValidateParameters
    implements SchedulingStrategy {
  private static final String STRATEGY_NAME = "alphabetical";

  @Override
  public String schedule(List<Assignment> assignmentList) {
    validateList(assignmentList);
    validateListContent(assignmentList);
    Collections.sort(assignmentList);
    return STRATEGY_NAME;
  }

}
