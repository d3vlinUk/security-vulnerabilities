#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=pytorch-data-loader-with-multiple-workers@v1.0 defects=1}
def pytorch_data_loader_with_multiple_workers_noncompliant():
    import torch
    from torch.utils.data import DataLoader
    import numpy as np
    sampler = InfomaxNodeRecNeighborSampler(g, [fanout] * (n_layers),
                                            device=device, full_neighbor=True)
    pr_node_ids = list(sampler.hetero_map.keys())
    pr_val_ind = list(np.random.choice(len(pr_node_ids),
                                    int(len(pr_node_ids) * val_pct),
                                    replace=False))
    pr_train_ind = list(set(list(np.arange(len(pr_node_ids))))
                        .difference(set(pr_val_ind)))
    loader = DataLoader(dataset=pr_train_ind,
                        batch_size=batch_size,
                        collate_fn=sampler.sample_blocks,
                        shuffle=True,
                        num_workers=8)

    optimizer = torch.optim.Adam(model.parameters(),
                                lr=lr,
                                weight_decay=l2norm)

    # training loop
    print("start training...")

    for epoch in range(n_epochs):
        model.train()
# {/fact}

