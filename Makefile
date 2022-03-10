up:
	docker compose -p demo up -d

down:
	docker compose -p demo down --remove-orphans

logs:
	docker compose -p demo logs -f
