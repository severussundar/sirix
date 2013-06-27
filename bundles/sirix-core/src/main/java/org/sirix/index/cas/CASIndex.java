package org.sirix.index.cas;

import java.util.Iterator;

import org.sirix.api.NodeReadTrx;
import org.sirix.api.PageReadTrx;
import org.sirix.api.PageWriteTrx;
import org.sirix.index.IndexDef;
import org.sirix.index.SearchMode;
import org.sirix.index.avltree.interfaces.References;
import org.sirix.index.path.PathFilter;
import org.sirix.index.path.summary.PathSummaryReader;
import org.sirix.node.interfaces.Record;
import org.sirix.page.UnorderedKeyValuePage;

import com.google.common.base.Optional;

public interface CASIndex<K extends Comparable<? super K>, V extends References> {

		CASIndexBuilder createBuilder(NodeReadTrx rtx,
				PageWriteTrx<Long, Record, UnorderedKeyValuePage> pageWriteTrx,
				PathSummaryReader pathSummaryReader, IndexDef indexDef);

		CASIndexListener createListener(
				PageWriteTrx<Long, Record, UnorderedKeyValuePage> pageWriteTrx,
				PathSummaryReader pathSummaryReader, IndexDef indexDef);

		Iterator<V> openIndex(PageReadTrx pageReadTrx, Optional<K> key, IndexDef indexDef, SearchMode mode, PathFilter filter);
}
