package jp.happyhacking70.cum3.presSvr.comLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactoryIntf;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpContentCompressor;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.handler.stream.ChunkedWriteHandler;

public class PresSvrHttSvrPipelineFactory implements ChannelPipelineFactory {

	protected int maxContentSize;
	protected PresSvrAdptr adaptor;
	protected ChnlRscFactoryIntf chnlRscFactory;

	public PresSvrHttSvrPipelineFactory(int maxContentSize,
			PresSvrAdptr adaptor, ChnlRscFactoryIntf chnlRscFactory) {
		super();
		this.maxContentSize = maxContentSize;
		this.adaptor = adaptor;
		this.chnlRscFactory = chnlRscFactory;
	}

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = Channels.pipeline();

		pipeline.addLast("decoder", new HttpRequestDecoder());
		pipeline.addLast("aggregator", new HttpChunkAggregator(maxContentSize));
		pipeline.addLast("encoder", new StringEncoder());
		pipeline.addLast("deflater", new HttpContentCompressor());

		pipeline.addLast("handler", new PresSvrHttpSvrHdlr(adaptor,
				chnlRscFactory));
		pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());
		return pipeline;
	}
}
