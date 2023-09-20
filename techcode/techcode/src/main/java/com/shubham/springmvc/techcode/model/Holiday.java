package com.shubham.springmvc.techcode.model;

import lombok.Data;

//@Data = (@Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode)
@Data
public class Holiday {
	
	private final String day;
	private final String reason;
	private final Type type;
	
	public enum Type{
		FESTIVAL, GOVERNMENT
	}
	
}
