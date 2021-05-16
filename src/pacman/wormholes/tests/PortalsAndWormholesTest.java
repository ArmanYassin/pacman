package pacman.wormholes.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Square;
import pacman.wormholes.Wormhole;

class PortalsAndWormholesTest {

	@Test
	void test() {
		MazeMap mazeMap = new MazeMap(4, 3, new boolean[] {
				true, false, true, true,
				true, true, false, true,
				false, true, true, true
		 	});
		Square square00 = Square.of(mazeMap, 0, 0);
		Square square02 = Square.of(mazeMap, 0, 2);
		Square square03 = Square.of(mazeMap, 0, 3);
		Square square10 = Square.of(mazeMap, 1, 0);
		Square square11 = Square.of(mazeMap, 1, 1);
		Square square21 = Square.of(mazeMap, 2, 1);
		ArrivalPortal arrivalportal1 = new ArrivalPortal(square00); 
		ArrivalPortal arrivalportal2 = new ArrivalPortal(square02); 
		DeparturePortal departureportal1 = new DeparturePortal(square03);
		DeparturePortal departureportal2 = new DeparturePortal(square10);
		Wormhole wormhole1 = new Wormhole(departureportal1, arrivalportal1);
		Wormhole wormhole2 = new Wormhole(departureportal1, arrivalportal2);
		assertEquals(square00, arrivalportal1.getSquare());
		assertEquals(square03, departureportal1.getSquare());
		assert(arrivalportal1.getWormholes().contains(wormhole1));
		assert(departureportal1.getWormholes().contains(wormhole1));
		assert(departureportal1.getWormholes().contains(wormhole2));
		assertEquals(wormhole1.getArrivalPortal(),arrivalportal1);
		wormhole1.setArrivalPortal(arrivalportal2);
		assertEquals(wormhole1.getArrivalPortal(),arrivalportal2);
		assert(arrivalportal2.getWormholes().contains(wormhole1));		
		assertEquals(wormhole1.getDeparturePortal(),departureportal1);
		wormhole1.setDeparturePortal(departureportal2);
		assertEquals(wormhole1.getDeparturePortal(),departureportal2);
		assert(departureportal2.getWormholes().contains(wormhole1));
	}
}
