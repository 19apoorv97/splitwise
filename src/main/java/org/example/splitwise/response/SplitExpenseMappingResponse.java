package org.example.splitwise.response;

import lombok.Builder;
import lombok.Getter;
import org.example.splitwise.model.User;

import java.util.Map;

@Builder
@Getter
public class SplitExpenseMappingResponse {
    Map<User, Map<User,Double>> borrowerToLenderMap;
}
