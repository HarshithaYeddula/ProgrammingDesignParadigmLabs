package assignments;

import java.util.List;

/**
 * 
 * Class To Validate parameters.
 *
 */
public abstract class ValidateParameters {

  /**
   * Validates if the provided list is valid.
   * 
   * @param assignmentList list of Assignment Objects.
   */
  protected void validateList(List<Assignment> assignmentList) {
    if (assignmentList == null) {
      throw new IllegalArgumentException("Assignment List cannot be null");
    }
  }

  /**
   * Validates each assignment present in the list.
   * 
   * @param assignmentList list of Assignment Objects.
   */
  protected void validateListContent(List<Assignment> assignmentList) {
    if (!assignmentList.isEmpty()) {
      for (Assignment assignment : assignmentList) {
        if (assignment == null) {
          throw new IllegalArgumentException("One of the Assignment is null!");
        }
      }
    }

  }

}
