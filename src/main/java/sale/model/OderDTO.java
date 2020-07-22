package sale.model;

import java.util.List;

public class OderDTO {
	private List<OrderItemDTO> itemDTOs;

	public List<OrderItemDTO> getItemDTOs() {
		return itemDTOs;
	}

	public void setItemDTOs(List<OrderItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}
	
}
