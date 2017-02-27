package com.ctrip.xpipe.redis.keeper.monitor.impl;

import com.ctrip.xpipe.redis.core.store.CommandStore;
import com.ctrip.xpipe.redis.keeper.RedisKeeperServer;
import com.ctrip.xpipe.redis.keeper.monitor.CommandStoreDelay;
import com.ctrip.xpipe.redis.keeper.monitor.KeeperMonitor;
import com.ctrip.xpipe.redis.keeper.monitor.KeeperStats;
import com.ctrip.xpipe.redis.keeper.monitor.KeepersMonitorManager;

/**
 * @author wenchao.meng
 *
 * Dec 13, 2016
 */
public class NoneKeepersMonitorManager extends AbstractKeepersMonitorManager implements KeepersMonitorManager{
	
	public static class NoneKeeperMonitor implements KeeperMonitor{
		
		private KeeperStats keeperStats = new DefaultKeeperStats(); 

		@Override
		public CommandStoreDelay createCommandStoreDelay(CommandStore commandStore) {
			return new NoneCommandStoreDelay();
		}

		@Override
		public KeeperStats getKeeperStats() {
			return keeperStats;
		}
	}

	@Override
	protected KeeperMonitor createKeeperMonitor(RedisKeeperServer redisKeeperServer) {
		return new NoneKeeperMonitor();
	}
}
