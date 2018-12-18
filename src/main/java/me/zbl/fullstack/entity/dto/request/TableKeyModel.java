package me.zbl.fullstack.entity.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 批量操作对主键的封装
 *
 * @author czbcxy
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TableKeyModel {

  private List<Integer> ids;
}
