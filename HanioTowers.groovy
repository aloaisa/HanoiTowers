///////////////////
// Hanoi Towers
// Groovy
//////////////////

class Tower {

	private List<Integer> disks
	private int index

	def Tower(int topLimit) {
		disks = []
		index = topLimit
	}

	int index() {
		index
	}

	void add(int item) {
		if (!disks.isEmpty() && disks[-1] <= item) {
			println "Error placing disk " + item
		} else {
			disks.push(item)
		}
	}

	void moveTopTo(Tower tower) {
		int top = disks.pop()
		tower.add(top)
		println "Move disk ${top} from ${index} to ${tower.index()}"
	}

	void moveDisks(int towerLevels, Tower destination, Tower buffer) {
		if (towerLevels > 0) {
			moveDisks(towerLevels - 1, buffer, destination)
			moveTopTo(destination)
			buffer.moveDisks(towerLevels - 1, destination, this)
		}
	}
}

int towersNumber = 3
int towerLevels = 4
Tower[] towers = new Tower[towerLevels]

for (int i = 0; i < towersNumber; i++) {
	towers[i] = new Tower(i)
}

for (int i = towerLevels - 1; i >= 0; i--) {
	towers[0].add(i)
}

towers[0].moveDisks(towerLevels, towers[2], towers[1])